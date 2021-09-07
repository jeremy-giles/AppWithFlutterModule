package com.jeremyg.myapplication

import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.plugin.common.MethodChannel


class FullScreenFlutterActivity : FlutterActivity() {

    private val CHANNEL = "CHANNEL"

    override fun onResume() {
        super.onResume()
        /*MethodChannel(
            FlutterEngineCache.getInstance()
                .get(FULL_SCREEN_ENGINE_ID)?.dartExecutor?.binaryMessenger, CHANNEL
        ).invokeMethod("notifyNavToFlutter", intent.getStringExtra("screen"))*/
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        /*MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->
                when (call.method) {
                    else -> result.notImplemented()
                }
            }*/
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        return FlutterEngineCache.getInstance().get(FULL_SCREEN_ENGINE_ID)
    }
}