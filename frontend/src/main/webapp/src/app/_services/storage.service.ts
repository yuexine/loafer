import {Injectable} from "@angular/core";

@Injectable()
export class StorageService {
  constructor() {
  }

  setItem(key: string, value: string) {
    localStorage.setItem(key, value);
  }

  getItem(key: string) {
    return localStorage.getItem(key);
  }

  removeItem(key: string) {
    return localStorage.removeItem(key);
  }
}
