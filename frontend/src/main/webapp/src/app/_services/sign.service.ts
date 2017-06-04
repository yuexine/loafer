import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response} from "@angular/http";
import "rxjs/add/operator/map";

import {User} from "../_models/index";
import {HttpClient} from "./http.service";

@Injectable()
export class SignService {
  constructor(private http: HttpClient) {
  }

  private apiAddr = "http://localhost:8080/";

  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  private headersForm = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
  private optionsForm = new RequestOptions({headers: this.headersForm});

  register(user: User) {
    let body = JSON.stringify({
      username: user.email,
      password: user.password
    });
    return this.http.post(this.apiAddr + 'register', body, this.options)
      .map((reponse: Response) => {
        return reponse.status;
      })
  }

  login(user: User) {
    let body = 'username=' + encodeURIComponent(user.username) +
      '&password=' + encodeURIComponent(user.password);
    return this.http.post(this.apiAddr + 'api/auth', body, this.optionsForm);
  }

  account() {
    return this.http.get(this.apiAddr + "account");
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

  currentUser() {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

}
