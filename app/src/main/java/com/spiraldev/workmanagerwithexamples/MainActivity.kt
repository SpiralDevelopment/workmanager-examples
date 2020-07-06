package com.spiraldev.workmanagerwithexamples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spiraldev.workmanagerwithexamples.CancelWorkers.CancelWorkersActivity
import com.spiraldev.workmanagerwithexamples.ChainingWorkers.ChainingWorkersActivity
import com.spiraldev.workmanagerwithexamples.ConstrainedWorkers.ConstrainedWorkersActivity
import com.spiraldev.workmanagerwithexamples.ObserveWorkers.ObserveWorkersActivity
import com.spiraldev.workmanagerwithexamples.SimpleWorkers.SimpleWorkersActivity
import com.spiraldev.workmanagerwithexamples.UniqueWorkers.UniqueWorkerActivity
import com.spiraldev.workmanagerwithexamples.WorkersWithInput.WorkerWithInputActivity
import com.spiraldev.workmanagerwithexamples.WorkersWithOutput.WorkerWithOutputActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simple_worker.setOnClickListener {
            startActivity(Intent(this, SimpleWorkersActivity::class.java))
        }

        constrained_worker.setOnClickListener {
            startActivity(Intent(this, ConstrainedWorkersActivity::class.java))
        }

        input_worker.setOnClickListener {
            startActivity(Intent(this, WorkerWithInputActivity::class.java))
        }

        unique_worker.setOnClickListener {
            startActivity(Intent(this, UniqueWorkerActivity::class.java))
        }

        observe_worker.setOnClickListener{
            startActivity(Intent(this, ObserveWorkersActivity::class.java))
        }

        worker_with_output.setOnClickListener{
            startActivity(Intent(this, WorkerWithOutputActivity::class.java))
        }

        chaining_workers.setOnClickListener{
            startActivity(Intent(this, ChainingWorkersActivity::class.java))
        }

        cancel_worker.setOnClickListener{
            startActivity(Intent(this, CancelWorkersActivity::class.java))
        }

    }
}