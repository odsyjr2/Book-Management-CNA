import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
    {
      path: '/publishManages',
      component: () => import('../components/ui/PublishManageGrid.vue'),
    },
    {
      path: '/subscribers',
      component: () => import('../components/ui/SubscriberGrid.vue'),
    },
    {
      path: '/services',
      component: () => import('../components/ui/ServiceGrid.vue'),
    },
    {
      path: '/admins',
      component: () => import('../components/ui/AdminGrid.vue'),
    },
    {
      path: '/bookLists',
      component: () => import('../components/BookListView.vue'),
    },
    {
      path: '/구독상태조회',
      component: () => import('../components/구독상태조회View.vue'),
    },
    {
      path: '/bestsellerLists',
      component: () => import('../components/BestsellerListView.vue'),
    },
  ],
})

export default router;
