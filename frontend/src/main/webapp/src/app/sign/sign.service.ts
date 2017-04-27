import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {User} from "./user";
import "rxjs/add/operator/map";

@Injectable()
export class SignService {
  constructor(private http: Http) {
  }


  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  login(user: User) {


    let body = JSON.stringify({
      username: user.username,
      password: user.password
    });

    return this.http.post('http://localhost:8080/login', body, this.options)
      .map((response: Response) => {
        let user = response.json().body;
        console.log(user);
        if (user) {
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      });
  }

}
