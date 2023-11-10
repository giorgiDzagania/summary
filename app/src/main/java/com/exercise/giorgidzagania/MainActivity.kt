package com.exercise.giorgidzagania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exercise.giorgidzagania.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val wordList = mutableListOf<String>()
    private val anagrams = mutableListOf<List<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val word = binding.editText.text.toString()
            if (word.isNotEmpty()) {
                wordList.add(word)
                binding.editText.text?.clear()
                updateUser()
            }
        }

        binding.btnOutput.setOnClickListener {
            groupAnagrams()
            updateAnagram()
            showAnagram()
        }
    }

    private fun groupAnagrams() {
        val anagramMap = mutableMapOf<String, MutableList<String>>()

        for (word in wordList) {
            val sortedWord = word.toCharArray().sorted().joinToString("")
            if (anagramMap.containsKey(sortedWord)) {
                anagramMap[sortedWord]!!.add(word)
            } else {
                anagramMap[sortedWord] = mutableListOf(word)
            }
        }
        anagrams.clear()
        anagrams.addAll(anagramMap.values)
    }

    private fun updateAnagram() {
        binding.anagramCount.text = anagrams.size.toString()
    }

    private fun updateUser() {
        binding.inputCount.text = wordList.size.toString()
    }

    private fun showAnagram() {
        binding.anagramCount.text = anagrams.size.toString()
    }
    
}