import {Injectable} from "@angular/core";
import {User} from "../sign/user";

@Injectable()
export class HomeService {

  currentUser() {
    let user: User = JSON.parse(localStorage.getItem('currentUser'));
    return user;
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

}
