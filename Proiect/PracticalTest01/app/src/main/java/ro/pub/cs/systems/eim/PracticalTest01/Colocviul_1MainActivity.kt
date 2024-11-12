package ro.pub.cs.systems.eim.PracticalTest01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class Colocviul_1MainActivity : AppCompatActivity() {

    private lateinit var pressMeButton: Button
    private lateinit var pressMeTooButton: Button
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var navigateToSecondActivityButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul_1_main)

        pressMeButton = findViewById(R.id.press_me_button)
        pressMeTooButton = findViewById(R.id.press_me_too_button)
        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        input1.setText("0")
        input2.setText("0")

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(
                    this,
                    "The activity returned with result REGISTER",
                    Toast.LENGTH_LONG
                ).show()

                input1.setText("0")
                input2.setText("0")
            } else {
                Toast.makeText(
                    this,
                    "The activity returned with result CANCELED",
                    Toast.LENGTH_LONG
                ).show()
                input1.setText("0")
                input2.setText("0")
            }
        }

        navigateToSecondActivityButton = findViewById(R.id.navigate_to_second_activity)
        navigateToSecondActivityButton.setOnClickListener {
            val intent = Intent(this, Colocviul_1SecondaryActivity::class.java)
            intent.putExtra(Constants.INPUT1, input1.text.toString().toInt())
            intent.putExtra(Constants.INPUT2, input2.text.toString().toInt())
            activityResultsLauncher.launch(intent)
        }

        pressMeButton.setOnClickListener {
            val sum = input1.text.toString().toInt() + 1
            input1.setText(sum.toString())
        }

        pressMeTooButton.setOnClickListener {
            val sum = input2.text.toString().toInt() + 1
            input2.setText(sum.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.INPUT1, input1.text.toString())
        outState.putString(Constants.INPUT2, input2.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(Constants.INPUT1) && savedInstanceState.containsKey(Constants.INPUT2)) {
            input1.setText(savedInstanceState.getString(Constants.INPUT1))
            input2.setText(savedInstanceState.getString(Constants.INPUT2))
        }
    }
}