package tech.interview.one.tech_interview_one.authorizer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizerService {
    private RestClient restClient;

    public AuthorizerService(RestClient.Builder builder){
        this.restClient = builder.
        baseUrl("https://util.devi.tools").
        build();
    }

    public void authorize(){
        Authorizer auth = null;
        
        try{
            auth = this.restClient.
            get().
            uri("/api/v2/authorize").
            retrieve().
            body(Authorizer.class);
        }catch(HttpClientErrorException e){
            throw new AuthorizerException(e.getMessage());
        }

        if(auth == null || auth.status().equals("fail")){
            throw new AuthorizerException(auth == null ? "Fail to authorize transaction" : auth.data().toString());
        }
    }
}
