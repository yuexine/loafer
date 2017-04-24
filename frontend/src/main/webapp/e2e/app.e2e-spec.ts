import { LoaferPage } from './app.po';

describe('loafer App', () => {
  let page: LoaferPage;

  beforeEach(() => {
    page = new LoaferPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
