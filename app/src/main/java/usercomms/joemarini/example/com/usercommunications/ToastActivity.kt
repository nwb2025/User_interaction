package usercomms.joemarini.example.com.usercommunications

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ToastActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        findViewById<View>(R.id.btnShowToast).setOnClickListener(this)
        findViewById<View>(R.id.btnShowCustomToast).setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnShowToast -> showToast()
            R.id.btnShowCustomToast -> showCustomToast()
        }
    }

    private fun showToast() {
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        val toast = Toast.makeText(this,"This is a toast ", toastDuration)
        toast.setGravity(Gravity.CENTER, 0,0)
        toast.show()

    }

    private fun showCustomToast() {
        // create layout for a toast
        // set arg view = your_layout
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        val layoutInflater = LayoutInflater.from(this)
        val layout = layoutInflater.inflate(R.layout.custom_toast_layout,
                        findViewById(R.id.customToastLayout))
        val textV = layout.findViewById<View>(R.id.textContent) as TextView
        textV.text = "This is a custom Toast "
        val toast = Toast(this).run{
            duration = toastDuration
            setGravity(Gravity.BOTTOM or Gravity.START, 100, 100)
            view = layout
            show()
        }




        // TODO: Build a toast message that uses the custom layout

    }
}
