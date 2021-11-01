package usercomms.joemarini.example.com.usercommunications

import android.graphics.Color

import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "AUC-SNACKBAR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        findViewById<View>(R.id.btnShowSnackbar).setOnClickListener(this)
        findViewById<View>(R.id.btnShowActionSnackbar).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnShowSnackbar -> showSnackbar()
            R.id.btnShowActionSnackbar -> showActionSnackbar()
        }
    }

    private fun showSnackbar() {
        val snackBar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
            "This is a snackbar", Snackbar.LENGTH_LONG)
        snackBar.show()

    }

    private fun showActionSnackbar() {
        val snackBar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
            "This is a snackBar", Snackbar.LENGTH_LONG)

        snackBar.setAction("Delete ?"){
            Toast.makeText(applicationContext,"Two messages were deleted !",Toast.LENGTH_SHORT).show()
        }
        snackBar.setAction("Send ?"){
            Toast.makeText(applicationContext,"Two messages were sent !",Toast.LENGTH_SHORT).show()
        }
        snackBar.setActionTextColor(Color.GREEN)
        snackBar.show()

    }

}
