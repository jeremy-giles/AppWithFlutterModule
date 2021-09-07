package com.jeremyg.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flutterEngine: FlutterEngine? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpFlutter()

        btn_full_screen.setOnClickListener {
            sendDataToFlutterModule("param1", 2)
        }
    }

    override fun onResume() {
        super.onResume()
        flutterEngine!!.lifecycleChannel.appIsResumed()
    }

    override fun onPause() {
        super.onPause()
        flutterEngine!!.lifecycleChannel.appIsInactive()
    }

    override fun onStop() {
        super.onStop()
        flutterEngine!!.lifecycleChannel.appIsPaused()
    }

    override fun onDestroy() {
        flutter_view!!.detachFromFlutterEngine()
        super.onDestroy()
    }

    private fun setUpFlutter() {
        if (flutterEngine == null) {
            flutterEngine = FlutterEngineCache.getInstance().get(PARTIAL_SCREEN_ENGINE_ID)
            flutterEngine!!
                .dartExecutor
                .executeDartEntrypoint(
                    DartExecutor.DartEntrypoint.createDefault()
                )
        }
        flutter_view.attachToFlutterEngine(flutterEngine!!)
    }

    private fun sendDataToFlutterModule(param1: String, param2: Int) {
        val intent = Intent(this, FullScreenFlutterActivity::class.java)
        intent.putExtra("param1", param1)
        intent.putExtra("param2", param2)
        startActivity(intent)
        // Test with new flutter engine
        //startActivity(FullScreenFlutterActivity.withNewEngine().build(this))
    }
}