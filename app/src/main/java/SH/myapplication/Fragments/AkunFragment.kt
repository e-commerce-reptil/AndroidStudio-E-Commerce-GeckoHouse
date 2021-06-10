package SH.myapplication.Fragments

import SH.myapplication.MenuAkun.CetakQrActivity
import SH.myapplication.MenuAkun.TentangAplikasiActivity
import SH.myapplication.R
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_akun.view.*
import kotlinx.android.synthetic.main.nav_bottom.*

class AkunFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (R.layout.fragment_akun)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_akun, container, false)

        view.Tvnama.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        view.Tvtelponhp.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        view.Tvalamat.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        view.Tvemail.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        view.Tvpassword.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        view.Tvcetakqr.setOnClickListener {
            startActivity(Intent(activity, CetakQrActivity::class.java))
        }
        view.Tvtentangaplikasi.setOnClickListener {
            startActivity(Intent(activity, TentangAplikasiActivity::class.java))
        }
        return view
    }
}