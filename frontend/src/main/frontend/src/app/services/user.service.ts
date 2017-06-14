import {Injectable} from "@angular/core";

@Injectable()
export class UserService{

  currentUser: any = this.getCurrentUser() ? this.getCurrentUser() : {};

  setCurrentUser(currentUser: object) {
    localStorage.setItem('currentUser', JSON.stringify(currentUser));
  }

  getCurrentUser(): object {
    let user = localStorage.getItem('currentUser');
    return user ? JSON.parse(user) : {};
  }

  removeCurrentUser() {
    localStorage.removeItem('currentUser');
  }
}
