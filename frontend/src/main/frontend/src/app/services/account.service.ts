import {Injectable} from "@angular/core";
import {HttpService} from "./http.service";
import {Response} from "@angular/http";
import {User} from "../models/User";
import "rxjs/add/operator/map";

@Injectable()
export class AccountService {

  constructor(private http: HttpService) {
  }

  create(user: User) {
    return this.http.post('http://localhost:8080/api/account/register', user).map((response: Response) => response.json());
  }

}
