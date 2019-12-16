package com.nf.exam.controller;

import com.nf.exam.dao.QuestionBankDao;
import com.nf.exam.dao.TestPaperDao;
import com.nf.exam.entity.TestPaper;
import com.nf.exam.entity.TestPaperTestsList;
import com.nf.exam.entity.vo.QuestionBankVo;
import com.nf.exam.entity.vo.TestPaperTestsVo;
import com.nf.exam.service.QuestionBankService;
import com.nf.exam.service.TestPaperService;
import com.nf.exam.service.TestPaperTestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author
 * @ClassName lwb
 * @Description TODO
 * @Date 2019/12/5 20:58
 */
@Controller
@RequestMapping("/admin")
public class TestPaperController {
    @Autowired
    private TestPaperService testPaperService;
    @Autowired
    private QuestionBankDao questionBankDao;
    @Autowired
    private TestPaperTestsService testPaperTestService;
    @Autowired
    private TestPaperDao testPaperDao;

    /**
     * 查询有效试卷
     * @return
     */
    @RequestMapping(value = "/testPaper.html")
    public ModelAndView findTestPaperInfo(){
        ModelAndView modelAndView = new ModelAndView();
//        List<TestPaper> testPapers= testPaperService.findTestPaperInfo();
//        modelAndView.addObject("TestPaper",testPapers);
        modelAndView.setViewName("admin/test-paper");
        return modelAndView;
    }

    /**
     * 响应json类型数据
     * 查询所有试卷
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getalltestpaper")

    public List<TestPaper> getAllTestPaper(){
        List<TestPaper> testPapers = testPaperService.findTestPaperInfo();
        return testPapers;
    }

    /**
     * 改变试卷状态即表示删除
     * @param testPaperId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testDelete",method = RequestMethod.GET)
    public String updateTestPaperInfo(String testPaperId){
        int row =testPaperService.updateTestPaperState(Integer.parseInt(testPaperId));
        if (row>=1){
            return "1";
        }else {
            return "0";
        }

    }
    @ResponseBody
    @RequestMapping(value="/editTestPaperInfo.html")
    public ModelAndView editTestPaperInfo(HttpServletRequest request, HttpServletResponse response){
        int testpaperId=Integer.parseInt(request.getParameter("testpaperId"));
        TestPaper testPaper=testPaperService.selectByPrimaryKey(testpaperId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testPaper", testPaper);
        modelAndView.setViewName("admin/editTestPapperInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/testPaperEdit")
    public String userEdti(TestPaper testPaper)throws Exception{

        int j=testPaperService.updateTestPaperInfo(testPaper);
        if (j >= 1) {
            return "1";
        }
        return "0";

    }

    @ResponseBody
    @RequestMapping(value = "/findalltestpager")
    public List<QuestionBankVo> findAllQuestionBank(){
        List<QuestionBankVo> findAllQuestionBank = questionBankDao.findAllQuestionBank();
        return findAllQuestionBank;
    }
    @RequestMapping(value = "/addaddtestpaer")
    public boolean addTestPaer() {

        return true;
    }
    @ResponseBody
    @RequestMapping(value = "/editItemList.html")
    public ModelAndView editItemList(HttpServletRequest request){
        int testPaperId=Integer.parseInt(request.getParameter("testpaperId"));
List<QuestionBankVo> questionBankVos =
        questionBankDao.findAllQuestionBank();
        System.out.println("testPaperId = " + testPaperId);
List<TestPaperTestsVo> testPaperTestsVos =
        testPaperTestService.findSelectTestPaperQuesion(testPaperId);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("findAllQuestionBank",questionBankVos);
    modelAndView.addObject("selectIdTestPaperQuesion",testPaperTestsVos);
    modelAndView.setViewName("admin/editItemList");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/editTestPaperQuestion")
    public String editTestPaperQuestion(@RequestBody TestPaperTestsList testPaperTestsList, HttpServletRequest request, HttpServletResponse response){
        int j=testPaperTestService.deleteTestPaperTestById(testPaperTestsList.getTestpaperId());
        int addTestPaperQuestion = testPaperTestService.addTestPaperQuestion(testPaperTestsList);
        System.out.println(addTestPaperQuestion);
        if(addTestPaperQuestion>=1){
            return "1";
        }else{
            return "0";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/addtestpaper")
    public boolean addTestPaper(TestPaper testPaper) {
        testPaper.setTestpaperState(1);
        int insertSelective = testPaperDao.insertSelective(testPaper);
        if (insertSelective>=1) {
            return true;
        }
        return false;
    }
}
