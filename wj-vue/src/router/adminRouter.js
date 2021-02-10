import adminHome from '@/components/admin/adminMenu'

export default {
  path: '/admin',
  component: adminHome,
  children: [
    {
      name: 'aliAuction',
      path: '',
      component: () => import('@/components/common/About'),
      meta: {
        title: 'aliAuction',
        zoneConfig: { root: 'featureConfig', firstLevel: 'CROSS_BOOKING', secondLevel: 'ALI_AUCTION' },
        authRequired: true,
        effectiveRole: ['USER', 'PRIMARY_USER'],
        effectiveAuth: ['ALL']
      }
    }
  ]
}
