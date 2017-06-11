import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptionsArgs, RequestOptions} from "@angular/http";
import {isNull, isUndefined} from "util";

@Injectable()
export class HttpService{
  tokenKey = 'X-AuthToken';

  constructor(private http: Http) {
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
    headers.append(this.tokenKey, localStorage.getItem(this.tokenKey));
    return options;
  }

  get(url: string, options?: RequestOptionsArgs) {
    return this.http.get(url, this.createAuthorizationHeader(options));
  }

  post(url: string, body: any, options?: RequestOptionsArgs) {
    return this.http.post(url, body, this.createAuthorizationHeader(options));
  };

  put(url: string, body: any, options?: RequestOptionsArgs) {
    return this.put(url, body, this.createAuthorizationHeader(options));
  };

  delete(url: string, options?: RequestOptionsArgs) {
    return this.delete(url, this.createAuthorizationHeader(options));
  };
}
