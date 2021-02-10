<template>
    <el-menu style="margin-top: 30px;margin-left: 10px;width: 160px;">
      <a href="#header-div">
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <span slot="title">技术采用</span>
        </el-menu-item>
      </a>
      <a href="#update-card">
        <el-menu-item index="3">
          <i class="el-icon-location"></i>
          <span slot="title">最近更新</span>
        </el-menu-item>
      </a>
      <a href="#slogan">
        <el-menu-item index="4">
          <i class="el-icon-document"></i>
          <span slot="title">下载源码</span>
        </el-menu-item>
      </a>
      <a href="#about">
        <el-menu-item index="5">
          <i class="el-icon-setting"></i>
          <span slot="title">关于我们</span>
        </el-menu-item>
      </a>
    </el-menu>
</template>

<script>
    export default {
        name: "SideMenu"
    }
</script>

<style scoped>
  a {
    text-decoration: none;
    color: inherit;
  }
</style>
