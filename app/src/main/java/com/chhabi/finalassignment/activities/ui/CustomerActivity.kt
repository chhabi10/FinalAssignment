package com.chhabi.finalassignment.activities.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Adapter.UserAdapter
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Entity.Useraccount
import com.chhabi.finalassignment.activities.ui.Repository.CustomerRepository
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import com.chhabi.finalassignment.activities.ui.Repository.UseraccountRepository
import com.chhabi.finalassignment.activities.ui.model.DataInsertedNotification
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception
import java.util.*


class  CustomerActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var etfname: EditText
    private lateinit var etlname: EditText
    private lateinit var etidentity: EditText
    private lateinit var etdob: EditText
    private lateinit var etaddress: EditText
    private lateinit var btnsubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        etfname = findViewById(R.id.etfname)
        etlname = findViewById(R.id.etlname)
        etidentity = findViewById(R.id.etidentity)
        etdob = findViewById(R.id.etdob)
        etaddress = findViewById(R.id.etaddress)
        imgProfile = findViewById(R.id.imgProfile)
        btnsubmit = findViewById(R.id.btnsubmit)

        btnsubmit.setOnClickListener {
            addCustomer()
        }
        imgProfile.setOnClickListener {
            loadPopUpMenu()
        }


    }


    private fun loadPopUpMenu() {
        val popupMenu = PopupMenu(this@CustomerActivity, imgProfile)
        popupMenu.menuInflater.inflate(R.menu.gallery_camera, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menuCamera ->
                    openCamera()
                R.id.menuGallery ->
                    openGallery()
            }
            true
        }
        popupMenu.show()
    }

    private var REQUEST_GALLERY_CODE = 0
    private var REQUEST_CAMERA_CODE = 1
    private var imageUrl: String? = null
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_GALLERY_CODE)
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CAMERA_CODE)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_GALLERY_CODE && data != null) {
                val selectedImage = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val contentResolver = contentResolver
                val cursor =
                        contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
                cursor!!.moveToFirst()
                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                imageUrl = cursor.getString(columnIndex)
                imgProfile.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
                cursor.close()
            } else if (requestCode == REQUEST_CAMERA_CODE && data != null) {
                val imageBitmap = data.extras?.get("data") as Bitmap
                val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
                val file = bitmapToFile(imageBitmap, "$timeStamp.jpg")
                imageUrl = file!!.absolutePath
                imgProfile.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
//          uploadImage()
            }
        }
    }

    private fun bitmapToFile(
            bitmap: Bitmap,
            fileNameToSave: String
    ): File? {
        var file: File? = null
        return try {
            file = File(
                    getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                            .toString() + File.separator + fileNameToSave
            )
            file.createNewFile()
            //Convert bitmap to byte array
            val bos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos) // YOU can also save it in JPEG
            val bitMapData = bos.toByteArray()
            //write the bytes in file
            val fos = FileOutputStream(file)
            fos.write(bitMapData)
            fos.flush()
            fos.close()
            file
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            file // it will return null
        }
    }


    private fun addCustomer() {
        val Fname = etfname.text.toString()
        val Lname = etlname.text.toString()
        val Identity = etidentity.text.toString()
        val Dob = etdob.text.toString()
        val Address = etaddress.text.toString()

        val customer = Customer(fname = Fname, lname = Lname, identity = Identity, dob = Dob, address = Address)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val customerRepository = CustomerRepository()
                val response = customerRepository.addCustomer(customer)
                if (response.success == true) {
                    withContext(Main) {
                        Toast.makeText(
                                this@CustomerActivity,
                                "Student added successfully",
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                    startActivity(
                            Intent(
                                    this@CustomerActivity,
                                    ButtomNav::class.java
                            )
                    )
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@CustomerActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        DataInsertedNotification()
    }


    private fun DataInsertedNotification() {
        val notificationManager = NotificationManagerCompat.from(this)
        val datainsertedNotification = DataInsertedNotification(this)
        datainsertedNotification.createNotificationChannel()

        val notification = NotificationCompat.Builder(this, datainsertedNotification.CHHANEL1)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("Notification")
                .setContentText("User is added!")
                .setColor(Color.BLACK)
                .build()
        notificationManager.notify(1, notification)


    }



//    private fun uploadImage() {
//        val userId = ServiceBuilder.userData!![0]._id
//        if (imageUrl != null) {
//            val file = File(imageUrl!!)
//            val reqFile =
//                    RequestBody.create(MediaType.parse("image/jpeg"), file)
//            val body =
//                    MultipartBody.Part.createFormData("photo", file.name, reqFile)
//            CoroutineScope(Dispatchers.IO).launch {
//                try {
//                    val customerRepository = CustomerRepository()
//                    val response = customerRepository.uploadImage(userId!!, body)
//                    if (response.success == true) {
//                        withContext(Dispatchers.Main) {
//                            Toast.makeText(this@CustomerActivity, "Uploaded", Toast.LENGTH_SHORT)
//                                    .show()
//                        }
//                    }
//                } catch (ex: Exception) {
//                    withContext(Dispatchers.Main) {
//                        Log.d(" Error ", ex.localizedMessage)
//                        Toast.makeText(
//                                this@CustomerActivity,
//                                ex.localizedMessage,
//                                Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            }
//        }
//    }
}


