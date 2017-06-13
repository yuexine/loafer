//https://stackoverflow.com/questions/36158848/what-is-the-best-way-to-declare-a-global-variable-in-angular-2-typescript

export const GlobalVariable = Object.freeze({
  VERSION: '0.0.1-snapshot',            //project version
  API_URL: 'http://localhost:8080/',    //api address link
  TOKEN_KEY: 'X-AuthToken',             //jwt token name
});
