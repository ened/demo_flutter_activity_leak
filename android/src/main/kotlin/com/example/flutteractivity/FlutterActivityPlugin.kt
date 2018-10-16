package com.example.flutteractivity

import android.util.Log
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterActivityPlugin() : MethodCallHandler {

    companion object {
        val TAG = "FlutterActivityPlugin"
        @JvmStatic
        fun registerWith(registrar: Registrar): Unit {
            val plugin = FlutterActivityPlugin()
            val channel = MethodChannel(registrar.messenger(), "flutter_activity")
            channel.setMethodCallHandler(plugin)
            registrar.addViewDestroyListener {
                plugin.destroy()
                Log.d(TAG, "View destroyed")
                false
            }
        }
    }

    override fun onMethodCall(call: MethodCall, result: Result): Unit {
        Log.d(TAG, "method called: ${call.method}")

        if (call.method.equals("getPlatformVersion")) {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else {
            result.notImplemented()
        }
    }

    fun destroy() {
        Log.d(TAG, "Destroy")
    }
}
