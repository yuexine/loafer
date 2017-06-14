import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, RequestOptionsArgs} from "@angular/http";
import {isNull, isUndefined} from "util";
import {GlobalVariable} from "../configs/globals";
import {UserService} from "./user.service";

@Injectable()
export class HttpService {

  apiUrl = GlobalVariable.API_URL;
  tokenKey = GlobalVariable.TOKEN_KEY;

  constructor(private http: Http,
              private userService: UserService) {
  }

  createAuthorizationHeader(options?: RequestOptionsArgs) {
    if (isUndefined(options) || isNull(options)) {
      options = new RequestOptions({});
    }
    let headers = options.headers;
    if (isUndefined(headers) || isNull(headers)) {
      headers = new Headers();
      options.headers = headers;
    }
    headers.append(this.tokenKey, this.userService.currentUser.token);
    return options;
  }

  get(url: string, options?: RequestOptionsArgs) {
    return this.http.get(this.apiUrl + url, this.createAuthorizationHeader(options));
  }

  post(url: string, body: any, options?: RequestOptionsArgs) {
    return this.http.post(this.apiUrl + url, body, this.createAuthorizationHeader(options));
  };

  put(url: string, body: any, options?: RequestOptionsArgs) {
    return this.put(this.apiUrl + url, body, this.createAuthorizationHeader(options));
  };

  delete(url: string, options?: RequestOptionsArgs) {
    return this.delete(this.apiUrl + url, this.createAuthorizationHeader(options));
  };
}
