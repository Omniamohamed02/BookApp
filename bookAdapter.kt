package com.example.books

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class BookAdapter(private val books: List<Books>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val bookImage: ImageView = row.findViewById(R.id.book_image)
        val bookName: TextView = row.findViewById(R.id.book_name)
        val authorName: TextView = row.findViewById(R.id.author_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bookImage.setImageResource(book.images)
        holder.bookName.text = book.bookName
        holder.authorName.text = book.authorName
    }
}
