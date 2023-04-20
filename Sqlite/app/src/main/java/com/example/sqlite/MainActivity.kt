package com.example.sqlite

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_result)

        val db = DataBaseHelper(this)

        val list1 = db.getNodesPlace()
        val list2 = db.getNodesCross()

        var text = "list1\n\n"

        for (i in list1) {
            text += "${i.idx}, ${i.name}, ${i.x}, ${i.y}, ${i.x1}, ${i.y1}, ${i.x2}, ${i.y2}\n"
        }

        text += "\nlist2\n\n"

        for (i in list2) {
            text += "${i.idx}, ${i.x}, ${i.y}, ${i.x1}, ${i.y1}, ${i.x2}, ${i.y2}\n"
        }

        for (i in list1) {
            if ((i.x1 <= 920 && 920 <= i.x2) && (i.y1 <= 440 && 440 <= i.y2)) {
                text += "\nindex = ${i.idx}"
            }
        }

        textView.text = text
    }
}