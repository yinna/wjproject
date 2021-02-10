<template>
  <el-row style="height: 840px;">
    <el-tooltip content="Right Bottom 提示文字" placement="right">
      <p slot="content" style="font-size: 14px;margin-bottom: 6px;">书名：</p>
      <p slot="content" style="font-size: 14px;margin-bottom: 6px;">
        <span slot="content">出版社：</span> /
        <sapn>作者：</sapn>
        <span>出版日期：</span>
      </p>
      <p slot="content" style="font-size: 14px;margin-bottom: 6px;">简介：</p>
      <el-card :body-style="{ padding: '10px' }" style="width: 220px">
        <div class="cover">
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
        </div>
        <div class="info">
          <div class="title" style="padding: 14px;">
            <a>书名</a>
          </div>
          <i class="el-icon-delete"></i>
        </div>
        <div class="author">作者</div>
      </el-card>
    </el-tooltip>
  </el-row>
</template>

<script>
    import EditForm from "@/components/library/EditForm";
    export default {
      name: "Books1",
      components: {EditForm},
      data() {
        return {
          item: {
            id:'',
            title:'',
          }
        };
      }
    }
</script>

<style scoped>
  .title {
    font-size: 14px;
    text-align: left;
  }

  a {
    text-decoration: none;
  }
  a:link, a:visited, a:focus {
    color: #3377aa;
  }

  .el-icon-delete {
    cursor: pointer;
    float: right;
  }

  .author {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }
</style>
