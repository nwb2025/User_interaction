package usercomms.joemarini.example.com.usercommunications

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

import java.util.Calendar

import usercomms.joemarini.example.com.usercommunications.Dialogs.CustomDialogFragment
import usercomms.joemarini.example.com.usercommunications.Dialogs.SingleChoiceDialogFragment
import usercomms.joemarini.example.com.usercommunications.Dialogs.SimpleDialogFragment

class DialogActivity : AppCompatActivity(),
    View.OnClickListener,
    SimpleDialogFragment.SimpleDialogListener{

    private val TAG = "AUC_DLG_ACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        // set up button click handlers
        findViewById<View>(R.id.btnSimpleDialog).setOnClickListener(this)
        findViewById<View>(R.id.btnShowDatePicker).setOnClickListener(this)
        findViewById<View>(R.id.btnShowChoiceDialog).setOnClickListener(this)
        findViewById<View>(R.id.btnShowCustomDialog).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSimpleDialog -> showSimpleDialog()
            R.id.btnShowDatePicker -> {
                // TODO: Get a calendar instance
                val cal = Calendar.getInstance()

                // TODO: Create a DatePickerDialog
                val datePicker = DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                            Log.i(TAG, String.format("Date Chosen -- day: %d, month: %d, year: %d",
                                    dayOfMonth,monthOfYear,year))
                        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))

                // TODO: Set the title and show the dialog
                datePicker.setTitle("Choose a Date")
                datePicker.show()
            }
            R.id.btnShowChoiceDialog -> showChoiceDialog()
            R.id.btnShowCustomDialog -> showCustomDialog()
        }
    }

    private fun showSimpleDialog() {
        val simpleDialog = SimpleDialogFragment()
        // TODO: Use setCancelable() to make the dialog non-cancelable
        // TODO: If we want that user choose one of two options ( can't cancell )
        simpleDialog.isCancelable = false
        simpleDialog.show(supportFragmentManager, "SimpleDialogFragment")
    }

    private fun showCustomDialog() {
        val customDialog = CustomDialogFragment()
        customDialog.show(supportFragmentManager, "CustomDialogFragment")
    }

    private fun showChoiceDialog() {
        val complexDialog = SingleChoiceDialogFragment()
        complexDialog.show(supportFragmentManager, "SingleChoiceDialogFragment")
    }

    override fun onPositiveResult(dlg: DialogFragment) {
        Toast.makeText(this ,"Positive ", Toast.LENGTH_SHORT).show()
    }

    override fun onNegativeResult(dlg: DialogFragment) {
        Toast.makeText(this ,"Negative ", Toast.LENGTH_SHORT).show()
    }

    override fun onNeutralResult(dlg: DialogFragment) {
        Toast.makeText(this,"Neutral ", Toast.LENGTH_SHORT).show()
    }
}

