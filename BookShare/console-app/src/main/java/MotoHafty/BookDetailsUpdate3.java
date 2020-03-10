package MotoHafty;

public class  BookDetailsUpdate3 extends AddNewBook1 {

    public Integer askUserForBookId (){
        Library library = new Library();
//        Book book = new Book();
        System.out.println("_________________________________");
        System.out.println("Wprowadź Id ksiązki, której dane chcesz zaktualizować: ");
        Integer pickedId = scanner.nextInt();
        for (Integer i: library.getBooks().keySet()){
            if (library.getBooks().keySet().contains(i)){
                System.out.println("Wybrano książkę do edycji: ");
                System.out.println("#########################################");
                System.out.println("ID: " + pickedId);
                System.out.println("Tytuł: " + library.getBooks().get(pickedId).getTitle());
                System.out.println("Główny autor: " + library.getBooks().get(pickedId).getMainAuthorName());


                return pickedId;
            }
        }return pickedId;
    }

    public Book updateBookDetails (Integer bookId) {
        return null;
    }
}
