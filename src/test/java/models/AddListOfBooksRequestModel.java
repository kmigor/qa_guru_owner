package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddListOfBooksRequestModel {

    String userId;
    List<IsbnModel> collectionOfIsbns;

}
