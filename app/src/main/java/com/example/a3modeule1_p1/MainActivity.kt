package project.handson1

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import project.handson1.databinding.ActivityMainBinding
import project.handson1.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        viewModel.response.observe(this) { response ->
            binding.tvResponse.text = response
        }

        viewModel.loading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.btnAskAI.isEnabled = !isLoading
        }
    }

    private fun setupListeners() {
        binding.btnAskAI.setOnClickListener {
            val prompt = binding.etPrompt.text.toString().trim()
            if (prompt.isNotEmpty()) {
                viewModel.askAI(prompt)
            } else {
                binding.etPrompt.error = "Please enter a prompt"
            }
        }
    }
}
