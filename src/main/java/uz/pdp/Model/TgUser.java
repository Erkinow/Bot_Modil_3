package uz.pdp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TgUser {
    private UUID id=UUID.randomUUID();
    private String chatId;
    private String fio;
    private String username;
    private String phoneNumber;
    private String state;
    private String codnikurish;
    private boolean isAdmin;


    public TgUser(String chatId, String state) {
        this.chatId = chatId;
        this.state = state;
    }

}
