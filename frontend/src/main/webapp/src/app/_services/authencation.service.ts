import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "./http.service";

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient) {
  }

  private apiAddr = "http://localhost:8080/";

  logout() {
    localStorage.removeItem("X-AuthToken");
  }

  login(username, password): Observable<Response> {
    //build form
    let headersForm = new Headers({'Content-Type': 'application/x-www-form-urlencoded'});
    let optionsForm = new RequestOptions({headers: headersForm});

    let body = 'username=' + encodeURIComponent(username) +
      '&password=' + encodeURIComponent(password);
    return this.http.post(this.apiAddr + 'api/auth', body, optionsForm);
  }
}
