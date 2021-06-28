<template>
  <div>
    <h3>学生情報一覧</h3>
    <div class="content">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="学生番号">
          <el-input v-model="formInline.studentNo"></el-input>
        </el-form-item>
        <el-form-item label="名前">
          <el-input v-model="formInline.name"></el-input>
        </el-form-item>
        <el-form-item label="クラス">
          <el-select v-model="formInline.classNo">
            <el-option label="クラス01" value="01"></el-option>
            <el-option label="クラス02" value="02"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary">検索</el-button>
        </el-form-item>
      </el-form>

      <!-- Table -->
      <el-table :data="tableData" stripe style="width: 90%">
        <el-table-column fixed prop="studentNo" label="学生番号" width="150">
        </el-table-column>
        <el-table-column prop="name" label="名前"> </el-table-column>
        <el-table-column prop="sex" label="性別"> </el-table-column>
        <el-table-column prop="classNo" label="クラス"> </el-table-column>
        <el-table-column prop="phone" label="電話番号"> </el-table-column>
        <el-table-column label="操作">
          <template>
            <el-button type="text" size="small"
              >編集</el-button
            >
            <el-button
              type="text"
              size="small"
              >削除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
export default {
  name: "userInfo",
  data() {
    return {
      formInline: {
        studentNo: "",
        name: "",
        classNo: "",
      },
      tableData: [],
    };
  },
  created() {
    this.getUserInfo();
  },
  methods: {
    getUserInfo() {
      this.axios.get("/api/usersInfo").then((res) => {
        this.tableData = res.data;
        this.tableData.forEach((item) => {
          item.sex = item.sex == "0" ? "男" : "女";
        });
      });
    },
  },
  components: {},
};
</script>
<style lang="scss" scoped>
.content {
  margin-top: 20px;
}
</style>
