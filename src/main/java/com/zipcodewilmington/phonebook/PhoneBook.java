package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {


        private final Map<String, List<String>> phonebook;

        public PhoneBook(Map<String, List<String>> map) {
            this.phonebook = map;
        }

        public PhoneBook() {
            this(new LinkedHashMap<>());
        }

        public void add(String name, String phoneNumber) {
            if (this.phonebook.containsKey(name)) {
                this.phonebook.get(name).add(phoneNumber);
            } else {
                List<String> numberList = new ArrayList<>();
                numberList.add(phoneNumber);
                this.phonebook.put(name, numberList);
                
            }
        }
        public void addAll(String name, String... phoneNumbers) {
            for(String number : phoneNumbers){
                add(name, number);
            }
        }

        public void remove(String name) {
            this.phonebook.remove(name);
        }

        public Boolean hasEntry(String name){

            return this.phonebook.containsKey(name);
        }

        public Boolean hasEntry(String name, String phoneNumber) {

            return this.phonebook.containsKey(name) &&
                    this.phonebook.get(name).contains(phoneNumber);
        }

        public List<String> lookup(String name) {
            return this.phonebook.get(name);
        }

        public String reverseLookup(String phoneNumber)  {
            for(String check : phonebook.keySet()){
                if(hasEntry(check, phoneNumber)){
                    return check;
                }
            }
            return null;
        }

        public List<String> getAllContactNames() {
            List<String> newList = new ArrayList<>();
            for (String name : phonebook.keySet())
                newList.add(name);
            return newList;
        }

        public Map<String, List<String>> getMap() {
            return new HashMap<>(this.phonebook);
        }
    }