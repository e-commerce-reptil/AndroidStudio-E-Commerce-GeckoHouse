package SH.myapplication

import SH.myapplication.Fragments.AkunFragment
import SH.myapplication.Fragments.ArtikelFragment
import SH.myapplication.Fragments.ScanFragment
import SH.myapplication.Fragments.UtamaFragment
import SH.myapplication.Splash.SplashScreenBuilder
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    // Initialise the NavigationBattomBar
    private lateinit var bottomNavigation: BottomNavigationView

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentcontainer, fragment)
            commit()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startSplashScreen()

        // Call fragment from bottom navigation view
        val firstFragment = UtamaFragment()
        val secondFragment = ArtikelFragment()
        val thirdFragment = ScanFragment()
        val fourthFragment = AkunFragment()

        setCurrentFragment(firstFragment)

        bottomNavigation = findViewById(R.id.navBottom)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_utama -> setCurrentFragment(firstFragment)
                R.id.navigation_artikel -> setCurrentFragment(secondFragment)
                R.id.navigation_scan -> setCurrentFragment(thirdFragment)
                R.id.navigation_akun -> setCurrentFragment(fourthFragment)
            }
            true
        }
    }
    // Call inflate toobar Menu to Main Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    //Clicked item toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.search) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.myOrders) {
            Toast.makeText(this, "Go to My Orders", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //Splash
    private fun startSplashScreen() {
        SplashScreenBuilder.getInstance(this)
            .setVideo(R.raw.splash_animation)
            .setVideoDark(R.raw.splash_animation_dark)
            .setImage(R.drawable.app_icon)
            .setTitle(R.string.Welcome)
            .setSubtitle(R.string.app_name)
            .show()
    }
    //Splash
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SplashScreenBuilder.SPLASH_SCREEN_FINISHED) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "SplashScreen finished, but canceled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
