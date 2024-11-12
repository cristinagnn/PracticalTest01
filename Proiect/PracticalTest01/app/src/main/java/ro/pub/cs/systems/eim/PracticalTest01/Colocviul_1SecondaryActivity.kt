package ro.pub.cs.systems.eim.PracticalTest01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Colocviul_1SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul_1_secondary)

        val displaySuma = findViewById<TextView>(R.id.suma)
        val input1 = intent.getIntExtra(Constants.INPUT1, 0)
        val input2 = intent.getIntExtra(Constants.INPUT2, 0)
        val sum = input1 + input2
        displaySuma.text = sum.toString()

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}