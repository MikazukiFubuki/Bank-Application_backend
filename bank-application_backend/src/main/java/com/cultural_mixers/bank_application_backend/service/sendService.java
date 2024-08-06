package main.java.com.cultural_mixers.bank_application_backend.service;


@Service
@Transactional
public class SendService {
    // @AutoWired 
    // SendRepository sendRepository;

    private boolean checkSendingIsAvailable(string se_user_id, int money) {
        //int remainMoney = sendRepository.getRemainMoneyByUserID(string se_user_id);
        if (remainMoney < money) {
            return false;
        } else {
            return true;
        }
        // if (sendRepository.getMoney(se_user_id) < money) {
        //     throw new NotEnoughMoneyException();
        // }
    }   


     private int updateMoney(string se_user_id, string re_user_id,int money) {
        boolean isSendingAvailable =  checkSendingIsAvailable(se_user_id, money);
        if (isSendingAvailable) {
             //return sendRepository.updateMoney(se_user_id, re_user_id, money);
        } else {
            throw new NotEnoughMoneyException();
        }
       
    }
}
