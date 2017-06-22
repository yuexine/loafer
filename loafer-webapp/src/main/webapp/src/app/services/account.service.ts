import {Injectable} from "@angular/core";
import {HttpService} from "./http.service";
import {Response, URLSearchParams} from "@angular/http";
import {User} from "../models/User";
import "rxjs/add/operator/map";
import {UserService} from "./user.service";

@Injectable()
export class AccountService {

  constructor(private http: HttpService,
              private userService: UserService) {
  }

  create(user: User) {
    return this.http.post('api/register', user).map((response: Response) => response.json());
  }

  login(user: User) {
    let body = new URLSearchParams();
    body.set('username', user.username);
    body.set('password', user.password);
    return this.http.post('api/auth', body);
  }

  loginSuccess(token: string | any) {
    this.userService.currentUser.token = token;
    this.updateUserDetail();
  }

  updateUserDetail() {
    if (this.userService.currentUser.token) {
      this.http.get('api/account/info').map((response: Response) => response.json()).subscribe(
        data => {
          //todo
          console.log(data);
          this.userService.setCurrentUser(this.userService.currentUser);
        }, error => {
          console.log(error)
        }
      )
    }
  }
}
