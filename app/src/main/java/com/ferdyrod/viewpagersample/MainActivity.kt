package com.ferdyrod.viewpagersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ferdyrod.viewpagersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        binding.viewPager.invalidate()
        setupViewpager()
    }

    private fun setupViewpager() {
        adapter = if (isPortrait()) Adapter(this, SIZE.FOUR) else Adapter(this, SIZE.THREE)

        binding.viewPager?.let {
            it.adapter = adapter
        }

        if (!isPortrait()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, FragmentA(), "Frag_A")
                .commit()
        }
    }
}
