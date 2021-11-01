package usercomms.joemarini.example.com.usercommunications.Dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog

class SimpleDialogFragment : DialogFragment() {
    private val TAG = "AUC_SIMPLE"

    // TODO: Implement an interface to send callback results

    private var mHost: SimpleDialogListener? = null

    interface SimpleDialogListener {
        fun onPositiveResult(dlg:DialogFragment)
        fun onNegativeResult(dlg:DialogFragment)
        fun onNeutralResult(dlg:DialogFragment)

    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // TODO: Create an AlertDialog.Builder instance
        val builder = AlertDialog.Builder(activity!!)

        // TODO: Set dialog properties
        builder.setTitle("Peas preference")
        builder.setMessage("Do you like sugar snap peas?")

        builder.setPositiveButton("Sure!") { dialog, which ->
            Log.i(TAG, "positive button was clicked")
            mHost!!.onPositiveResult(this@SimpleDialogFragment)
        }
        builder.setNegativeButton("No way!") { dialog, which ->
            Log.i(TAG, "negative button was clicked")
            mHost!!.onNegativeResult(this@SimpleDialogFragment)
        }
        builder.setNeutralButton("Not sure") { dialog, which ->
            Log.i(TAG, "neutral button was clicked")
            mHost!!.onNeutralResult(this@SimpleDialogFragment)
        }
        // TODO: return the created dialog
        return builder.create()
    }

    // TODO: override onCancel to listen for dialog cancel
    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Log.i(TAG, "Dialog canceled")
    }


    // callback for result
    override fun onAttach(context: Context) {
        // store  a reference to an activity that called this dialog
        super.onAttach(context)
        mHost = context as SimpleDialogListener // to have a reference to an activity
    }
}
