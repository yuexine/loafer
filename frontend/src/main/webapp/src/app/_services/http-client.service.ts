import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, RequestOptionsArgs} from "@angular/http";
import {StorageService} from "./storage.service";
import {isNull, isUndefined} from "util";

@Injectable()
export class HttpClient {

  constructor(private http: Http, private storageService: StorageService) {
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
    headers.append('X-AuthToken', this.storageService.getItem("X-AuthToken"));
    return options;
  }

  /**
   * Performs a request with `get` http method.
   */
  get(url: string, options?: RequestOptionsArgs) {
    return this.http.get(url, this.createAuthorizationHeader(options));
  }

  /**
   * Performs a request with `post` http method.
   */
  post(url: string, body: any, options?: RequestOptionsArgs) {
    return this.http.post(url, body, this.createAuthorizationHeader(options));
  };

  /**
   * Performs a request with `put` http method.
   */
  put(url: string, body: any, options?: RequestOptionsArgs) {
    return this.put(url, body, this.createAuthorizationHeader(options));
  };

  /**
   * Performs a request with `delete` http method.
   */
  delete(url: string, options?: RequestOptionsArgs) {
    return this.delete(url, this.createAuthorizationHeader(options));
  };
}
