# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import get_object_or_404,render
from django.template import loader
from django.urls import reverse
from django.http import HttpResponse, HttpResponseRedirect, JsonResponse
from .models import Choice,Question
import csv 
import math

def index(request):
    argument=str(request)
    i=argument.index("=")
    arg=""
    i+=1
    while argument[i]!='\'':
        arg+=argument[i]
        i+=1
    arg = int(arg)
    parseFile("data")
    arg = fourSum(foodPrices, arg)
    return JsonResponse({'Combination' : arg[0]})

def detail(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    return render(request, 'polls/detail.html', {'question': question})

def results(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    return render(request, 'polls/results.html', {'question': question})
def hello(request):
    return JsonResponse({'foo':'bar'})
def vote(request, question_id):
    return JsonResponse({'foo':'bar'})

dictionary={}
foodPrices = []
def parseFile(fileName):
    with open(fileName + ".csv", "rt") as f:
        reader = csv.reader(f)
        for row in reader:
            dictionary[row[0]] = float(row[1])
            foodPrices.append((row[0], math.ceil(float(row[1]))))

def fourSum(num, target):
        num = sorted(foodPrices, key = lambda x: x[1])
        def ksum(num, k, target):
            i = 0
            result = set()
            if k == 2:
                j = len(num) - 1
                while i < j:
                    if num[i][1] + num[j][1] == target:
                        result.add((num[i], num[j]))
                        i += 1
                    elif num[i][1] + num[j][1] > target:
                        j -= 1
                    else:
                        i += 1
            else:
                while i < len(num) - k + 1:
                    newtarget = target - num[i][1]
                    subresult = ksum(num[i+1:], k - 1, newtarget)
                    if subresult:
                        result = result | set( (num[i],) + nr for nr in subresult)
                    i += 1
                
            return result
        
        return [list(t) for t in ksum(num, 4, target)]

dictionary={}
foodPrices = []
def parseFile(fileName):
    with open(fileName + ".csv", "rt") as f:
        reader = csv.reader(f)
        for row in reader:
            dictionary[row[0]] = float(row[1])
            foodPrices.append((row[0], math.ceil(float(row[1]))))
parseFile("data")

#    question = get_object_or_404(Question, pk=question_id)
#    try:
#        selected_choice = question.choice_set.get(pk=request.POST['choice'])
#    except (KeyError, Choice.DoesNotExist):
#        # Redisplay the question voting form.
#        return render(request, 'polls/detail.html', {
#                      'question': question,
#                      'error_message': "You didn't select a choice.",
#                      })
#    else:
#        selected_choice.votes += 1
#        selected_choice.save()
#        # Always return an HttpResponseRedirect after successfully dealing
#        # with POST data. This prevents data from being posted twice if a
#        # user hits the Back button.
#        return JsonResponse({'foo':'bar'})#HttpResponseRedirect(reverse('polls:results', args=(question.id,)))
