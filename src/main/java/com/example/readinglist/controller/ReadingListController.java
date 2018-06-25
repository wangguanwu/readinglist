package com.example.readinglist.controller;

import com.example.readinglist.dao.ReadingListReponsitory;
import com.example.readinglist.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListReponsitory readingListReponsitory;
    @Autowired
    public ReadingListController(ReadingListReponsitory readingListReponsitory){
        this.readingListReponsitory = readingListReponsitory;
    }
    @RequestMapping(value="/{reader}",method=RequestMethod.GET)
    public  String readerBooks(@PathVariable(value="reader")String reader, Model model){
        List<Book> readingList = readingListReponsitory.findByReader(reader);
        if(readingList!=null){
            model.addAttribute("books",readingList);
        }
        return "readingList";
    }
    @RequestMapping(value="/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable(value="reader") String reader,Book book){
        book.setReader(reader);
        readingListReponsitory.save(book);
        return "redirect:/{reader}";
    }

}
