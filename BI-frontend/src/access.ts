/**
 * @see https://umijs.org/zh-CN/plugins/plugin-access
 * 控制权限页面
 * */
export default function access(initialState: { currentUser?: API.CurrentUser } | undefined) {
  const { currentUser } = initialState ?? {};
  return {
    canAdmin: currentUser && currentUser.access === 'admin',
  };
}