package SH.myapplication

import SH.myapplication.DataClass.SchemaData
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.BarcodeUtils.encodeBitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.encoder.QRCode
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_create_qrcode.*
import java.io.File
import java.io.FileOutputStream

class CreateQRCodeActivity : AppCompatActivity(), View.OnClickListener {

    private var qrImage: Bitmap? = null
    val EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_qrcode)
        btn_save.setOnClickListener(this)
        btn_generateQR.setOnClickListener(this)


        if (!checkPermissionForExternalStorage()) {
            requestPermissionForExternalStorage()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.btn_generateQR-> {
                if (edit_text_morph.text.toString()
                        .isNullOrEmpty() && edit_text_parent.text.toString().isNullOrEmpty()
                    && edit_text_dob.text.toString()
                        .isNullOrEmpty() && edit_text_sex.text.toString().isNullOrEmpty()
                ) {
                    Toast.makeText(
                        applicationContext,
                        "Data tidak boleh kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    generateQRCode()
                }
            }
            R.id.btn_save-> {
                if (!checkPermissionForExternalStorage()) {
                    Toast.makeText(this, "Diperlukan izin Penyimpanan Eksternal. Harap izinkan di Pengaturan Aplikasi untuk fungsionalitas tambahan.", Toast.LENGTH_LONG).show()
                }
                else
                {
                    if(qrImage != null){saveImage(qrImage!!)}
                }
            }
        }
    }
    fun generateQRCode()
    {   val Generate = SchemaData(edit_text_morph.text.toString())
        .setParent(edit_text_parent.text.toString())
        .setDob(edit_text_dob.text.toString())
        .setSex(edit_text_sex.text.toString())

        qrImage =
            net.glxn.qrgen.android.QRCode.from(Generate).bitmap()
        if(qrImage != null)
        {
            imageView_qrCode.setImageBitmap(qrImage)
            imageView_qrCode.visibility = View.VISIBLE
            btn_save.visibility = View.VISIBLE
        }
    }
    //function for requesting storage access
    fun requestPermissionForExternalStorage() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Izin Penyimpanan Eksternal diperlukan. Harap izinkan di Pengaturan Aplikasi untuk fungsionalitas tambahan.", Toast.LENGTH_LONG).show()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE), EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE)
        }
    }
    //fuunction for checking storage permission
    fun checkPermissionForExternalStorage(): Boolean {

        val result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true
        } else {
            return false
        }
    }
    //funtion for saving image into gallery
    fun saveImage(image: Bitmap): String {
        var savedImagePath: String? = null

        var imageFileName = "QR" + getTimeStamp() + ".jpg"
        var storageDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "/QRGenerator")
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            var imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.getAbsolutePath()
            try {
                var fOut = FileOutputStream(imageFile)
                image.compress(Bitmap.CompressFormat.JPEG, 100, fOut)
                fOut.close()
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

            // Add the image to the system gallery
            var mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            var f = File(savedImagePath)
            var contentUri = Uri.fromFile(f)
            mediaScanIntent.setData(contentUri)
            sendBroadcast(mediaScanIntent)
            Toast.makeText(this,"Gambar disimpan ke Galeri", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Gagal menyimpan gambar", Toast.LENGTH_SHORT).show()
        }
        return savedImagePath!!
    }


    fun getTimeStamp(): String? {
        val tsLong = System.currentTimeMillis() / 1000
        val ts = tsLong.toString()

        return ts
    }
}