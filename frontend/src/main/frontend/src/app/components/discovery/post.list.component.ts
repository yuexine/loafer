import {Component, Input, OnInit, AfterViewInit} from "@angular/core";
@Component({
  selector: 'post-list',
  templateUrl: './post.list.component.html',
})

export class PostListComponent implements OnInit{

  @Input() category: 'latest' | 'recommend' | 'hot' | 'comment';

  title = "Post List"

  constructor(){
  }

  ngOnInit(): void {
    this.title = this.category
  }

  currentPage = 1;

  data = {
    count: 108,
    content: [
      {
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'springcloud 与 jwt 整合 如何设计微服务结构',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 234,
        votes: 120
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'restTemplate微服务调用问题',
        summary: '',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 234,
        votes: 120
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'FeignClient的单元测试',
        summary: '我在用junit测试feignClient的时候，在测试类上添加如下注解@as',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 234,
        votes: 120
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'springcloud 与 jwt 整合 如何设计微服务结构',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 234,
        votes: 120
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'application.yml的加载顺序',
        summary: '如题，我在zuul的注册服务中心的时候，发现只能在application.yml里，不能在application-dev.yml（已经active）里，这个bug找了好久。终于找到了。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 1234567,
        votes: 123
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'feign-使用最佳实践',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 11229,
        votes: 233334
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'Spring cloud config',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 23,
        votes: 1
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'springcloud 与 jwt 整合 如何设计微服务结构',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 23,
        votes: 1
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'springcloud 与 jwt 整合 如何设计微服务结构',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 45,
        votes: 0
      },{
        user: {
          avatar: 'http://spring4all.com/static/common/avatar-max-img.png',
          username: '',
          link: ''
        },
        title: 'springcloud 与 jwt 整合 如何设计微服务结构',
        summary: '我在 springcloud 中 集成进了jwt 验证, 起初想法是在 zuul 过滤器中验证jwt的角色,然后根据路由来判断是否有权限访问。',
        tags: [
          {
            name: 'Spring',
            link: 'spring',
          }, {
            name: 'Angular',
            link: 'angular',
          }, {
            name: 'Docker',
            link: 'docker',
          }
        ],
        views: 2,
        votes: 1
      }
    ]
  }

}
