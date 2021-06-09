package SH.myapplication.MenuAkun

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidmads.library.qrgenearator.QRGSaver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CetakQrActivity : AppCompatActivity() {
//    private var edtValue: EditText? = null
//    private var qrImage: ImageView? = null
//    private var inputValue: String? = null
//    private val savePath = Environment.getExternalStorageDirectory().path + "/QRCode/"
//    private var bitmap: Bitmap? = null
//    private var qrgEncoder: QRGEncoder? = null
//    private var activity: AppCompatActivity? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        qrImage = findViewById(R.id.qr_image)
//        edtValue = findViewById(R.id.edt_value)
//        activity = this
//        findViewById<View>(R.id.generate_barcode).setOnClickListener {
//            inputValue = edtValue.getText().toString().trim { it <= ' ' }
//            if (inputValue!!.length > 0) {
//                val manager =
//                    getSystemService(WINDOW_SERVICE) as WindowManager
//                val display = manager.defaultDisplay
//                val point = Point()
//                display.getSize(point)
//                val width = point.x
//                val height = point.y
//                var smallerDimension = if (width < height) width else height
//                smallerDimension = smallerDimension * 3 / 4
//                qrgEncoder = QRGEncoder(
//                    inputValue, null,
//                    QRGContents.Type.TEXT,
//                    smallerDimension)
//                try {
//                    bitmap = qrgEncoder.getBitmap()
//                    qrImage.setImageBitmap(bitmap)
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            } else {
//                edtValue.setError(resources.getString(R.string.value_required))
//            }
//        }
//        findViewById<View>(R.id.save_barcode).setOnClickListener {
//            if (ContextCompat.checkSelfPermission(
//                    applicationContext,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE
//                ) == PackageManager.PERMISSION_GRANTED
//            ) {
//                try {
//                    val save: Boolean = QRGSaver().save(
//                        savePath,
//                        edtValue.getText().toString().trim { it <= ' ' },
//                        bitmap,
//                        QRGContents.ImageType.IMAGE_JPEG
//                    )
//                    val result = if (save) "Image Saved" else "Image Not Saved"
//                    Toast.makeText(activity, result, Toast.LENGTH_LONG).show()
//                    edtValue.setText(null)
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            } else {
//                ActivityCompat.requestPermissions(
//                    Activity(),
//                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
//                    0
//                )
//            }
//        }
//    }
}


