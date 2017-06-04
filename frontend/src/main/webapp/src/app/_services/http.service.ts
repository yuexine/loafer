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
