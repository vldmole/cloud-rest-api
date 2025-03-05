package learning.java.bankApp.dto;

import learning.java.bankApp.domain.model.Account;
import learning.java.bankApp.domain.model.Card;
import learning.java.bankApp.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user)
    {
        UserDtoBuilder builder = new UserDtoBuilder();

        return builder
                .id(user.getId())
                .name(user.getName())
                .accountAgency(user.getAccount().getAgency())
                .accountNumber(user.getAccount().getNumber())
                .accountBalance(user.getAccount().getBalance())
                .accountCreditLimit(user.getAccount().getCreditLimit())
                .cardNumber(user.getCard().getNumber())
                .cardLimit(user.getCard().getCreditLimit())
                .build();
    }

    public User toUser(UserDto userDto)
    {
        User user = new User();

        user.setName(userDto.name());

        Account account = new Account();
        account.setAgency(userDto.accountAgency());
        account.setNumber(userDto.accountNumber());
        account.setBalance(userDto.accountBalance());
        account.setCreditLimit(userDto.accountCreditLimit());
        user.setAccount(account);

        Card card = new Card();
        card.setNumber(userDto.cardNumber());
        card.setCreditLimit(userDto.cardLimit());
        user.setCard(card);

        return user;
    }
}