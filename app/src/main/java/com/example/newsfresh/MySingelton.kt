package com.example.newsfresh

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import java.lang.NullPointerException

class MySingelton constructor(context:Context) {
    companion object{
        @Volatile
        private var INSTANCE:MySingelton?=null
        fun getInstance(context:Context)=
            INSTANCE ?: synchronized(this){
                INSTANCE?: MySingelton(context).also {
                    INSTANCE=it
                }
            }
    }


    private val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }
    fun<T> addToRequestQueue(req: Request<T>)
    {
        requestQueue.add(req)
    }
}


