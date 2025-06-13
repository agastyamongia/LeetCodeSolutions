// books[0].title
// books[1].author
// group all books by author,
// return list of list of strings of book titles

public List<List<String>> groupBooks(List<Book> books) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (Book book : books) {
        if (!map.containsKey(book.author)) {
            map.put(book.author, new ArrayList<>());
        }
        map.get(book.author).add(book.title);
    }

    for (List<String> titles : map.values()) {
        Collections.sort(titles);
        // OR
        // titles.sort((a, b) -> a.compareTo(b));
    }

    return new ArrayList<>(map.values());
}

// time: O(n)
// space: O(n)

/*
HashMap:
key: author
values: titles

return values in a list of list of strings

- traverse through the list of books
- place titles into hashmap based on author 
    - getOrDefault(key, default)
- return values of keys
*/